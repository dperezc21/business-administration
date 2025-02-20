package com.dashboard.business_administration.application;

import com.dashboard.business_administration.domain.exceptions.SaleNotFoundException;
import com.dashboard.business_administration.domain.models.Category;
import com.dashboard.business_administration.domain.models.Sale;
import com.dashboard.business_administration.domain.repositories.CategoryUseCaseRepository;
import com.dashboard.business_administration.domain.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleUseCase {

    @Autowired private SaleRepository saleRepository;
    @Autowired private CategoryUseCaseRepository categoryUseCaseRepository;

    public Sale saveSale(Double price, String description, Integer quantities, Long categoryId) {
        Category findCategory = this.categoryUseCaseRepository.getCategoryById(categoryId);
        if(findCategory == null) return null;
        Sale saleToSave = new Sale(price, description, quantities, findCategory);
        this.saleRepository.saveSale(saleToSave);
        return saleToSave;
    }

    public List<Sale> getListSale() {
        return this.saleRepository.getAllSales();
    }

    public Sale getSaleById(Long saleId) throws SaleNotFoundException {
        Sale findSale = this.saleRepository.getSaleById(saleId);
        if(findSale == null) throw new SaleNotFoundException("sale not found");
        return findSale;
    }

    public void deleteSale(Long saleId) throws SaleNotFoundException {
        Sale saleToDelete = getSaleById(saleId);
        this.saleRepository.deleteSale(saleToDelete.getId());
    }

    public Sale updateSale(Sale saleToUpdate) throws SaleNotFoundException {
        Sale saleFound = this.getSaleById(saleToUpdate.getId());
        saleFound.setDescription(saleToUpdate.getDescription());
        saleFound.setPrice(saleToUpdate.getPrice());
        saleFound.setQuantities(saleToUpdate.getQuantities());
        this.saleRepository.updateSale(saleFound);
        return saleFound;
    }
}
