package br.com.codexbookstore.domain.stock;

import br.com.codexbookstore.domain.Entity;

import java.util.List;

public class Stock extends Entity {
    private String lotNumber;
    private List<StockItem> stockItems;
}
