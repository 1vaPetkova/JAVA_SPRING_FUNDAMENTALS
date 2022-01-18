package com.example.exam_prep_andreys.services.impl;

import com.example.exam_prep_andreys.models.binding.ItemAddBindingModel;
import com.example.exam_prep_andreys.models.entities.Category;
import com.example.exam_prep_andreys.models.entities.Item;
import com.example.exam_prep_andreys.models.services.CategoryServiceModel;
import com.example.exam_prep_andreys.models.services.ItemServiceModel;
import com.example.exam_prep_andreys.models.views.ItemDetailedViewModel;
import com.example.exam_prep_andreys.models.views.ItemViewModel;
import com.example.exam_prep_andreys.repositories.ItemRepository;
import com.example.exam_prep_andreys.services.CategoryService;
import com.example.exam_prep_andreys.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public boolean addItem(ItemAddBindingModel itemAddBindingModel) {
        try {
            ItemServiceModel itemServiceModel = this.modelMapper.map(itemAddBindingModel, ItemServiceModel.class);
            CategoryServiceModel categoryServiceModel = this.categoryService
                    .findCategoryByCategoryName(itemAddBindingModel.getCategory());
            Item item = this.modelMapper.map(itemServiceModel, Item.class);
            item.setCategory(this.modelMapper.map(categoryServiceModel, Category.class));
            this.itemRepository.save(item);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Long getTotalItems() {
        return this.itemRepository.count();
    }

    @Override
    public List<ItemViewModel> findItems() {
        return this.itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
                    createItemViewModel(itemViewModel, item);
                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }


    @Override
    public ItemDetailedViewModel getItemDetails(String id) {
        Item item = this.itemRepository.findById(id).orElse(null);
        ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
        createItemViewModel(itemViewModel, item);
        return new ItemDetailedViewModel(itemViewModel, item.getDescription());
    }

    @Override
    public void deleteItem(String id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public void deleteAllItems() {
        this.itemRepository.deleteAll();
    }

    private void createItemViewModel(ItemViewModel itemViewModel, Item item) {
        itemViewModel
                .setImageUrl(String.format("/img/%s-%s.jpg",
                        item.getGender().name(),
                        item.getCategory().getName().name()));
    }
}
