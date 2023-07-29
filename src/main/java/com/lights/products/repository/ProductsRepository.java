package com.lights.products.repository;
import com.lights.products.model.entity.ProductsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepository extends PagingAndSortingRepository<ProductsEntity, Integer> {

//     ProductsEntity saveAll(List<ProductsEntity> productsInputList);
       ProductsEntity getById(Long id);

       @Query(value = "SELECT p FROM ProductsEntity p")
       Page<ProductsEntity> getAllProducts(Pageable pageable);

//       @Override
//       Iterable<ProductsEntity> get(Sort sort);
}
