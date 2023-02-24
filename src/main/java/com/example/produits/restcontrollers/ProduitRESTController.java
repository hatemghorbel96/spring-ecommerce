package com.example.produits.restcontrollers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.produits.dto.ListProduit;
import com.example.produits.entitys.ImageModel;
import com.example.produits.entitys.Order;
import com.example.produits.entitys.Produit;
import com.example.produits.entitys.ProduitExcel;
import com.example.produits.entitys.User;
import com.example.produits.repository.ProduitRepository;
import com.example.produits.service.ProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin (origins = "*")
public class ProduitRESTController {
	
	@Autowired
	ProduitService produitservice;
	
	@Autowired
	ProduitRepository produitrepository;
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Produit> getAllProduits()
	{
		return produitservice.getAllProduits();
	}
	
	
	@RequestMapping(method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Produit createProduit(@RequestPart("produit") Produit produit,@RequestPart("imageFile")MultipartFile[]file) {
	//return 
		
		try {
			Set<ImageModel> image = uploadImage(file);
			produit.setProductImages(image);
			return produitservice.saveProduit(produit);
		}catch(Exception e)
			{
				System.out.println(e.getMessage());
				return null;
			}
	}
	
	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImageModel> imageModels = new HashSet<>();
		
		for (MultipartFile file: multipartFiles) {
			ImageModel imageModel = new ImageModel(
					null, file.getOriginalFilename(),
					file.getContentType(),
					file.getBytes()
					);
					imageModels.add(imageModel);
		}
		
		return imageModels;
	}
	
	
	/*
	 * @RequestMapping(method = RequestMethod.POST,consumes =
	 * {MediaType.MULTIPART_FORM_DATA_VALUE}) public Produit
	 * createProduit(@RequestBody Produit
	 * produit,@RequestPart("imageFile")MultipartFile[]file) { return
	 * produitservice.saveProduit(produit); }
	 */
	
	
	// id ili fel url houwa ili fel path w path houwa parameter mte3 id ili de type long
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("id") Long id) {
	return produitservice.getProduit(id);
	}
	
	
	
	// fel postman id yetekteb fel body
	/*
	 * @RequestMapping(method = RequestMethod.PUT) public Produit
	 * updateProduit(@RequestBody Produit produit) { return
	 * produitservice.updateProduit(produit); }
	 */
	
	@RequestMapping(method = RequestMethod.PUT,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Produit updateProduit(@RequestPart("produit") Produit produit,@RequestPart("imageFile")MultipartFile[]file) {
		try {
			Set<ImageModel> image = uploadImage(file);
			produit.setProductImages(image);
			return produitservice.saveProduit(produit);
		}catch(Exception e)
			{
				System.out.println(e.getMessage());
				return null;
			}
	}
	
	
	@RequestMapping(value = "addpromo/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Produit> addpromo(@RequestBody Produit p,@PathVariable("id") Long id) {
		
		Produit getProduit= produitservice.getProduit(id);
		getProduit.setNomProduit(getProduit.getNomProduit());
		getProduit.setPrixProduit(getProduit.getPrixProduit());
		getProduit.setTrend(getProduit.getTrend());
		getProduit.setPromo(p.getPromo());
		getProduit.setCategorie(getProduit.getCategorie());
		getProduit.setComments(getProduit.getComments());
		getProduit.setProductImages(getProduit.getProductImages());
		getProduit.setFavorits(getProduit.getFavorits());
		getProduit.setPub1(getProduit.getPub1());
		getProduit.setPub2(getProduit.getPub2());
		Produit updatedProduit =produitrepository.save(getProduit);	
	
	return ResponseEntity.ok().body(updatedProduit);
	}
	
	
	@RequestMapping(value = "trend/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Produit> trend(@RequestBody Produit p,@PathVariable("id") Long id) {
		
		Produit getProduit= produitservice.getProduit(id);
		getProduit.setNomProduit(getProduit.getNomProduit());
		getProduit.setPrixProduit(getProduit.getPrixProduit());
		getProduit.setTrend(p.getTrend());
		getProduit.setPromo(getProduit.getPromo());
		getProduit.setCategorie(getProduit.getCategorie());
		getProduit.setComments(getProduit.getComments());
		getProduit.setProductImages(getProduit.getProductImages());
		getProduit.setFavorits(getProduit.getFavorits());
		getProduit.setPub1(getProduit.getPub1());
		getProduit.setPub2(getProduit.getPub2());
		Produit updatedProduit =produitrepository.save(getProduit);	
	
	return ResponseEntity.ok().body(updatedProduit);
	}
	
	@RequestMapping(value = "pub1/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Produit> pub1(@RequestBody Produit p,@PathVariable("id") Long id) {
		
		Produit getProduit= produitservice.getProduit(id);
		getProduit.setNomProduit(getProduit.getNomProduit());
		getProduit.setPrixProduit(getProduit.getPrixProduit());
		getProduit.setTrend(getProduit.getTrend());
		getProduit.setPromo(getProduit.getPromo());
		getProduit.setCategorie(getProduit.getCategorie());
		getProduit.setComments(getProduit.getComments());
		getProduit.setProductImages(getProduit.getProductImages());
		getProduit.setFavorits(getProduit.getFavorits());
		getProduit.setBestoffer(getProduit.getBestoffer());
		getProduit.setPub1(p.getPub1());
		getProduit.setPub2(getProduit.getPub2());
		Produit updatedProduit =produitrepository.save(getProduit);	
	
	return ResponseEntity.ok().body(updatedProduit);
	}
	
	@RequestMapping(value = "pub2/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Produit> pub2(@RequestBody Produit p,@PathVariable("id") Long id) {
		
		Produit getProduit= produitservice.getProduit(id);
		getProduit.setNomProduit(getProduit.getNomProduit());
		getProduit.setPrixProduit(getProduit.getPrixProduit());
		getProduit.setTrend(getProduit.getTrend());
		getProduit.setPromo(getProduit.getPromo());
		getProduit.setCategorie(getProduit.getCategorie());
		getProduit.setComments(getProduit.getComments());
		getProduit.setProductImages(getProduit.getProductImages());
		getProduit.setFavorits(getProduit.getFavorits());
		getProduit.setPub1(getProduit.getPub1());
		getProduit.setBestoffer(getProduit.getBestoffer());
		getProduit.setPub2(p.getPub2());
		Produit updatedProduit =produitrepository.save(getProduit);	
	
	return ResponseEntity.ok().body(updatedProduit);
	}
	
	@RequestMapping(value = "bestoffer/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Produit> bestoffer(@RequestBody Produit p,@PathVariable("id") Long id) {
		
		Produit getProduit= produitservice.getProduit(id);
		getProduit.setNomProduit(getProduit.getNomProduit());
		getProduit.setPrixProduit(getProduit.getPrixProduit());
		getProduit.setTrend(getProduit.getTrend());
		getProduit.setPromo(getProduit.getPromo());
		getProduit.setCategorie(getProduit.getCategorie());
		getProduit.setComments(getProduit.getComments());
		getProduit.setProductImages(getProduit.getProductImages());
		getProduit.setFavorits(getProduit.getFavorits());
		getProduit.setPub1(getProduit.getPub1());
		getProduit.setBestoffer(p.getBestoffer());
		getProduit.setPub2(getProduit.getPub2());
		
		Produit updatedProduit =produitrepository.save(getProduit);	
	
	return ResponseEntity.ok().body(updatedProduit);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		produitservice.deleteProduitById(id);
	}
	
	@RequestMapping(value="prodscat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
	return produitservice.findByCategorieIdCat(idCat);
	}
	
	@RequestMapping(value="prodsByName/{nom}",method = RequestMethod.GET)
	public List<Produit> findByNomProduitContains(@PathVariable("nom") String nom) {
	return produitservice.findByNomProduitContains(nom);
	}
	
	@RequestMapping(value="prodsByPrix/{maxprod}/{minprod}",method = RequestMethod.GET)
	public List<Produit> findByPrixMaxMin(@PathVariable("maxprod") Double maxprod,@PathVariable("minprod") Double minprod) {
	return produitservice.findMaxPrix(maxprod, minprod);
	}
	
	/*
	 * @RequestMapping(value="getbyorder/{id}",method = RequestMethod.GET) public
	 * List<Produit> getProductsbyOrderId(@PathVariable("username") String username)
	 * { return produitrepository.getOrdersByUser(username); }
	 */
	
	
	
	
	  @RequestMapping(path = "addfavorit/{username}/{idProduit}",method =
	  RequestMethod.POST) public Produit addfavorit(@PathVariable("username")
	  String username,@PathVariable("idProduit") Long idProduit) { return
	  produitservice.addFavorit(username,idProduit); }
	  
	  @RequestMapping(path = "removefavorit/{username}/{nomProduit}",method =
	  RequestMethod.POST) public Produit removefavorit(@PathVariable("username")
	  String username,@PathVariable("nomProduit") String nomProduit) { return
	  produitservice.removeFavorit(username,nomProduit); }
	  
	  @GetMapping("export/excel")
	  public void exportToExcel(HttpServletResponse response) throws IOException {
	    	System.out.println("Export to Excel ...");
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=articles_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	        List<Produit> listProduits = produitservice.getAllProduits();
	        ProduitExcel excel = new ProduitExcel(listProduits);
	        excel.export(response);    
	    }  
	 
	
}
