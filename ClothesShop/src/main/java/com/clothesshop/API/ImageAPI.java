package com.clothesshop.API;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clothesshop.dto.ProductImageDto;
import com.clothesshop.entities.ProductImage;
import com.clothesshop.service.ProductImageService;
import com.google.gson.Gson;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
@CrossOrigin
public class ImageAPI {
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private ProductImageService productImageService;
	@PostMapping("/admin/uploadfile/api")
	public String UpLoadImage(@RequestParam("file") MultipartFile[] files) {
		String path = servletContext.getRealPath("/resources/images");
		for (MultipartFile multipartFile : files) {
			try {
				File f = new File(path + "/" + multipartFile.getOriginalFilename());
				byte[] byteImg = multipartFile.getBytes();
				Files.write(f.toPath(), byteImg, StandardOpenOption.CREATE);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@PostMapping("/admin/product-image/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.POST)
	public String createNewImage(@RequestBody String data) {
		Gson gson = new Gson();
		ProductImageDto[] productImageDtos = gson.fromJson(data, ProductImageDto[].class);
		String json = gson.toJson(productImageService.save(productImageDtos));
		return json;
	}
	
	@PutMapping("/admin/product-image/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.PUT)
	public String updateImage(@RequestBody String data) {
		Gson gson = new Gson();
		ProductImageDto productImageDto = gson.fromJson(data, ProductImageDto.class);
		ProductImage productImage = productImageService.findProductImageById(productImageDto.getId());
		String pathOldImage = productImage.getPath();
		if(productImageService.update(productImageDto)) {
			if(!productImageDto.getPath().equals(pathOldImage)) {
				String path = servletContext.getRealPath("/resources/images");
				File f = new File(path + "/" + pathOldImage);
				f.delete();
			}
			return "ok";
		}
		return null;
	}
	
	@DeleteMapping("/admin/product-image/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.DELETE)
	public String DeleteImage(@RequestBody String data) {
		Long id = Long.parseLong(data);
		ProductImage productImage = productImageService.findProductImageById(id);
		if(productImageService.deleteImageById(id)) {
			String path = servletContext.getRealPath("/resources/images");
				File f = new File(path + "/" + productImage.getPath());
				f.delete();
			return "ok";
		}
		return null;
	}
}
