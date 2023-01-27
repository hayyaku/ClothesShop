package com.clothesshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothesshop.dao.CategoryDao;
import com.clothesshop.dao.ColorDao;
import com.clothesshop.dao.ProductDAO;
import com.clothesshop.dao.ProductDetailDao;
import com.clothesshop.dao.ProductImageDao;
import com.clothesshop.dao.SizeDao;
import com.clothesshop.dto.ProductDetailDto;
import com.clothesshop.dto.ProductDto;
import com.clothesshop.dto.ProductImageDto;
import com.clothesshop.entities.Category;
import com.clothesshop.entities.Product;
import com.clothesshop.entities.ProductDetail;
import com.clothesshop.entities.ProductImage;
import com.clothesshop.filter.ProductFilter;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private SizeDao sizeDao;
	@Autowired
	private ProductImageDao productImageDao;
	@Autowired
	private ProductDetailDao productDetailDao;
	@Override
	public List<ProductDto> getRandom12Item() {
		List<Product> products = productDAO.getRandom12Item();
		List<ProductDto> productDtos = addProductDto(products);
		return productDtos;
	}
	
	@Override
	public ProductDto getProductById(Long id) {
		Product product = productDAO.getById(id);
		List<ProductDetail> productDetails =product.getProductDetails();
		ProductDto productDto = new ProductDto();
		List<ProductDetailDto> productDetailDtos = new ArrayList<ProductDetailDto>() ;
		for (ProductDetail productDetail : productDetails) {
			ProductDetailDto productDetailDto = new ProductDetailDto();
			productDetailDto.setColorId(productDetail.getColorId().getId());
			productDetailDto.setColor(productDetail.getColorId().getName());
			productDetailDto.setId(productDetail.getId());
			productDetailDto.setProduct_id(productDetail.getProductId().getId());
			productDetailDto.setQty(productDetail.getQty());
			productDetailDto.setSizeId(productDetail.getSizeId().getId());
			productDetailDto.setSize(productDetail.getSizeId().getName());
			productDetailDtos.add(productDetailDto);
		}
		List<ProductImage> productImages = product.getProductImages();
		List<ProductImageDto>productImageDtos=new ArrayList<ProductImageDto>();
		for (ProductImage productImage : productImages) {
			ProductImageDto productImageDto = new ProductImageDto(productImage.getId(), productImage.getPath(), productImage.getProductId().getId());
			productImageDtos.add(productImageDto);
		}
		productDto.setCategory(product.getCategoryId().getName());
		productDto.setCategoryId(product.getCategoryId().getId());
		productDto.setDescription(product.getDescription());
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setNewPrice(product.getNewPrice());
		productDto.setOldPrice(product.getOldPrice());
		productDto.setQty(product.getQty());
		productDto.setProductDetailDtos(productDetailDtos);
		productDto.setProductImageDtos(productImageDtos);
		
		return productDto;
	}

	@Override
	public ProductDto save(ProductDto productDto) {
		Product newProduct =new Product();
		newProduct.setName(productDto.getName());
		newProduct.setOldPrice(productDto.getOldPrice());
		newProduct.setNewPrice(productDto.getNewPrice());
		newProduct.setQty(productDto.getQty());
		newProduct.setDescription(productDto.getDescription());
		newProduct.setCategoryId(categoryDao.getById(productDto.getCategoryId()));
		productDAO.save(newProduct);
		//insert product detail
		if(newProduct.getId()!=null) {	
			List<ProductDetailDto> productDetailDtos = productDto.getProductDetailDtos();
			for (ProductDetailDto productDetailDto : productDetailDtos) {
				ProductDetail newProductDetail = new ProductDetail();
				newProductDetail.setProductId(newProduct);
				newProductDetail.setColorId(colorDao.getById(productDetailDto.getColorId()));
				newProductDetail.setSizeId(sizeDao.getById(productDetailDto.getSizeId()));
				newProductDetail.setQty(productDetailDto.getQty());
				productDetailDao.save(newProductDetail);
			}
			List<ProductImageDto> productImages = productDto.getProductImageDtos();
			for (ProductImageDto productImageDto : productImages) {
				ProductImage newProductImage = new ProductImage();
				newProductImage.setPath(productImageDto.getPath());
				newProductImage.setProductId(newProduct);
				productImageDao.save(newProductImage);
			}
			return productDto;			
		}
		return null;
	}

	@Override
	public ProductFilter filterProductByCategory(ProductFilter filter) {
		List<Category> category = categoryDao.getAllCategory();
		List<Long> ids = new ArrayList<Long>();
		//add category id cha đầu tiên
		ids.add(filter.getCategoryId());
		//add các category id con cháu
		ids.addAll(categoryIds(category,filter.getCategoryId()));
		
		int beginProduct = (filter.getCurentPage()-1)*9;
		List<Product> products = productDAO.getProductByCategoryId(ids, beginProduct);
		List<ProductDto> productDtos = addProductDto(products);
		int totalPage = 1 + productDAO.countProductByCategoryId(ids)/9;
		if(totalPage <=1) {
			totalPage=0;
		}
		ProductFilter productFilter = new ProductFilter();
		productFilter.setProductDtos(productDtos);
		productFilter.setTotalPage(totalPage);
		return productFilter;
	}

	@Override
	public boolean update(ProductDto productDto) {
		Product product = productDAO.getById(productDto.getId());
		product.setCategoryId(categoryDao.getById(productDto.getCategoryId()));
		product.setName(productDto.getName());
		product.setOldPrice(productDto.getOldPrice());
		product.setNewPrice(productDto.getNewPrice());
		product.setDescription(productDto.getDescription());
		return productDAO.update(product);
	}

	@Override
	public boolean deleteById(Long id) {
		return productDAO.deleteById(id);
	}
	
	private List<ProductDto> addProductDto(List<Product> products){
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Product product : products) {
			ProductDto productDto =new ProductDto();
			productDto.setCategory(product.getCategoryId().getName());
			productDto.setId(product.getId());
			productDto.setName(product.getName());
			productDto.setNewPrice(product.getNewPrice());
			productDto.setOldPrice(product.getOldPrice());
			productDto.setQty(product.getQty());
			productDto.setCategory(product.getCategoryId().getName());
			List<ProductImage>productImages=product.getProductImages();
			List<ProductImageDto>productImageDtos=new ArrayList<ProductImageDto>();
			for (ProductImage productImage : productImages) {
				ProductImageDto productImageDto = new ProductImageDto(productImage.getId(),productImage.getPath(),productImage.getProductId().getId());
				productImageDtos.add(productImageDto);
			}
			productDto.setProductImageDtos(productImageDtos);
			productDtos.add(productDto);
		}
		return productDtos;
	}
	
	//lấy các cactegory con không tính category cha đầu tiên
	private List<Long> categoryIds(List<Category> categories, Long parenId){
		List <Long> ids=new ArrayList<Long>();
		for (Category category : categories) {
			if(category.getParentId()==parenId) {
				ids.add(category.getId());
				if(checkchild(categories, category.getId())) {
					ids.addAll(categoryIds(categories,category.getId()));
				}
			}
		}
		return ids;
	}
	
	private boolean checkchild(List<Category> categories, Long id) {
		for (Category category : categories) {
			if(category.getParentId()==id)
				return true;
		}return false;
	}



}
