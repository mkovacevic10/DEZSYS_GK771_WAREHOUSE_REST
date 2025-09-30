package rest.warehouse;

import rest.model.WarehouseData;
import rest.model.ProductData;

import java.util.ArrayList;
import java.util.List;

public class WarehouseSimulation {

    private double getRandomDouble(int inMinimum, int inMaximum) {
        double number = (Math.random() * ((inMaximum - inMinimum) + 1)) + inMinimum;
        double rounded = Math.round(number * 100.0) / 100.0;
        return rounded;
    }

    private int getRandomInt(int inMinimum, int inMaximum) {
        int range = inMaximum - inMinimum + 1;
        int randomInt = inMinimum + (int)(Math.random() * range);
        return Math.max(inMinimum, Math.min(inMaximum, randomInt));
    }

    public WarehouseData getData(String inID) {
        WarehouseData data = new WarehouseData();
        data.setWarehouseID(inID);
        data.setWarehouseName("TGM Bahnhof");
        data.setWarehouseAddress("Wexstraße");
        data.setWarehousePostalCode("1210");
        data.setWarehouseCity("Wien");
        data.setWarehouseCountry("Österreich");

        String[] obstProducts = {"Orange", "Apfel", "Birne"};
        String[] saftProducts = {"Apfelsaft", "Orangensaft", "Birnensaft"};
        String[] kgUnits = {"Packung 1KG", "Packung 2KG", "Packung 3KG"};
        String[] literUnits = {"Packung 1L", "Packung 2L", "Packung 3L"};

        int productCount = getRandomInt(1, 4);
        ProductData[] selectedProducts = new ProductData[productCount];

        for(int i = 0; i < productCount; i++) {
            boolean isObst = getRandomInt(0, 1) == 0;

            String name;
            String category;
            String unit;

            if (isObst) {
                int productIndex = getRandomInt(0, obstProducts.length - 1);
                name = obstProducts[productIndex];
                category = "Obst";
                int unitIndex = getRandomInt(0, kgUnits.length - 1);
                unit = kgUnits[unitIndex];
            } else {
                int productIndex = getRandomInt(0, saftProducts.length - 1);
                name = saftProducts[productIndex];
                category = "Saft";
                int unitIndex = getRandomInt(0, literUnits.length - 1);
                unit = literUnits[unitIndex];
            }

            int quantity = getRandomInt(100, 3000);
            String productID = "00-" + getRandomInt(100000, 999999);

            selectedProducts[i] = new ProductData(productID, name, category, quantity, unit);
        }

        List<ProductData> productList = new ArrayList<>();
        for (ProductData selectedProduct : selectedProducts) {
            productList.add(selectedProduct);
        }
        data.setProduktdata(productList);
        return data;
    }
}