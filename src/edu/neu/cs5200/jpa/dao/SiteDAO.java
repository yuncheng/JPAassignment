package edu.neu.cs5200.jpa.dao;

import java.util.*;

import javax.persistence.*;

import edu.neu.cs5200.jpa.models.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/site")
public class SiteDAO {

	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_hw");
	EntityManager em = factory.createEntityManager();
	
	//crud
	
	//createSite
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site) {
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	//findSite
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Site findSite(@PathParam("id") Integer id) {
		return em.find(Site.class, id);
	}
	
	//findAllSites
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites() {
		Query query = em.createQuery("select site from Site site");
		return (List<Site>) query.getResultList();
	}
	
	//updateSite
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") int siteId, Site site) {
		em.getTransaction().begin();
		em.merge(site);
		em.getTransaction().commit();
		
		return findAllSites();
	}
	
	//deleteSite
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(@PathParam("id") int id) {
		em.getTransaction().begin();
		Site site = em.find(Site.class, id);
		em.remove(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	/*
	 * Originally the assignment asked for a path api/site that lacked an id:
	@DELETE
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(int id) {
		em.getTransaction().begin();
		Site site = em.find(Site.class, id);
		em.remove(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	*/
	
	public static void main(String[] args) {
		SiteDAO dao = new SiteDAO();
		
//		Site newSite = new Site(3,"Site 3",12.23,23.34);
//		newSite = dao.createSite(newSite);
//		System.out.println(newSite.getId());
//		
		Site test = dao.findSite(3);
//		System.out.println(test.getName());
		
//		dao.deleteSite(4);
		
//		test.setLatitude(100);
//		dao.updateSite(3, test);
		
		List<Site> sites = dao.findAllSites();
		for (Site site : sites) {
			System.out.println(site.getName());
		}
	}

}
