package com.example.exam_prep_andreys.services.impl;

import com.example.exam_prep_andreys.models.binding.ItemAddBindingModel;
import com.example.exam_prep_andreys.models.entities.Item;
import com.example.exam_prep_andreys.models.entities.enums.CategoryNameEnum;
import com.example.exam_prep_andreys.models.entities.enums.GenderEnum;
import com.example.exam_prep_andreys.models.services.ItemServiceModel;
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
            Item item = this.modelMapper.map(itemServiceModel, Item.class);
            item.setCategory(this.categoryService.findCategoryByCategoryName(itemAddBindingModel.getCategory()));
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
    public List<ItemViewModel> findProductsByCategoryNameAndGender(CategoryNameEnum categoryNameEnum, GenderEnum gender) {
        return this.itemRepository.findAllByCategory_NameAndGender(categoryNameEnum, gender)
                .stream()
                .map(item -> this.modelMapper.map(item, ItemViewModel.class))
                .collect(Collectors.toList());
    }
}
