package com.air.service.Impl;

import com.air.bean.Item;
import com.air.common.utils.Page;
import com.air.dao.ItemDao;
import com.air.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemDao itemDao;

    /**
     * 分页查询
     *
     * @param page
     * @param rows
     * @param itemName
     * @param contentId
     * @return
     */
    @Override
    public Page<Item> selectItemList(Integer page, Integer rows, String itemName, Integer subcategoryId) {
        Integer start = (page - 1) * rows;
        List<Item> itemList = itemDao.selectItemList(start, rows, itemName, subcategoryId);
        Integer itemListCount = itemDao.selectItemListCount(itemName, subcategoryId);
        Page<Item> itemPage = new Page<>();
        itemPage.setPage(page);
        itemPage.setRows(itemList);
        itemPage.setSize(rows);
        itemPage.setTotal(itemListCount);
        return itemPage;
    }

    /**
     * 通过Id查找产品
     *
     * @param itemId
     * @return
     */
    @Override
    public Item selectItemById(Long itemId) {
        return itemDao.selectItemById(itemId);
    }

    @Override
    public Boolean updateItemById(Item item) {
        return itemDao.updateItemById(item) == 1 ? true : false;
    }

    @Override
    public boolean deleteItemById(Long id) {
        return itemDao.deleteItemById(id) == 1 ? true : false;
    }
}
