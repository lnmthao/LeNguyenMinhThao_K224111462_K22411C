package com.lnmt.lenguyenminhthao_k224111462_k22411c.models;

import java.util.ArrayList;

public class ListProduct {
    private ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
        generateSampleData();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


    private void generateSampleData() {
        products.add(new Product(1, "P01", "Sữa rửa mặt", 32.40, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(2, "P02", "Kem chống nắng", 46.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(3, "P003", "Sữa rửa mặt Cetaphil Daily Facial Cleanser", 12.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(4, "P004", "Toner Klairs Supple Preparation Unscented", 18.50, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(5, "P005", "Dưỡng ẩm Neutrogena Hydro Boost Water Gel", 20.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(6, "P006", "Kem chống nắng Anessa Perfect UV Sunscreen", 25.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(7, "P007", "Kem mắt Olay Eyes", 23.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(8, "P008", "Sữa tắm Dove Deeply Nourishing", 8.50, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(9, "P009", "Bộ trang điểm 3CE Velvet Lip Tint", 22.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(10, "P010", "Nước hoa Dior Sauvage", 120.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(11, "P011", "Kem dưỡng ẩm Laneige Water Sleeping Mask", 35.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(12, "P012", "Chì kẻ mày Anastasia Beverly Hills", 28.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(13, "P013", "Bộ dưỡng tóc OGX Nourishing Coconut Milk", 18.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(14, "P014", "Mặt nạ giấy Innisfree My Real Squeeze Mask", 5.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(15, "P015", "Dầu tẩy trang Shu Uemura Anti/Oxi Skin", 45.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(16, "P016", "Serum Estee Lauder Advanced Night Repair", 100.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(17, "P017", "Kem chống nắng Biore UV Aqua Rich Watery Essence", 12.50, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(18, "P018", "Bộ trang điểm Too Faced Better Mascara", 29.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(19, "P019", "Nước hoa Chanel No. 5", 150.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
        products.add(new Product(20, "P020", "Dầu dưỡng tóc Moroccanoil", 30.00, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lsrv9u9gz6opf5.webp"));
    }

    public void addProduct(Product product) {
        int maxId = products.stream()
                .mapToInt(Product::getId)
                .max()
                .orElse(0);
        product.setId(maxId + 1);
        products.add(product);
    }
}
