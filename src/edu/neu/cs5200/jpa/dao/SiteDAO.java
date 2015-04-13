package edu.neu.cs5200.jpa.dao;

import java.util.List;

import javax.persistence.*;

import edu.neu.cs5200.jpa.models.Site;
import edu.neu.cs5200.jpa.models.Tower;

public class SiteDAO {

	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_hw");
	EntityManager em = factory.createEntityManager();
	
	//crud
	
	//createSite
	public Site createSite(Site site) {
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		return site;
	}
	
	//readSiteById
	public Site findSite(Integer id) {
		return em.find(Site.class, id);
	}
	//readAllSites
	public List<Site> findAllSites() {
		Query query = em.createQuery("select site from Site site");
		return (List<Site>) query.getResultList();
	}
	//updateSite
	public List<Site> updateSite(int siteId, Site site) {
		em.getTransaction().begin();
		em.merge(site);
		em.getTransaction().commit();
		
		return findAllSites();
	}
	//deleteSite
	public void removeSite(int id) {
		em.getTransaction().begin();
		Site site = em.find(Site.class, id);
		em.remove(site);
		em.getTransaction().commit();
	}
	

	
	public static void main(String[] args) {
		SiteDAO dao = new SiteDAO();
		
//		Site site = new Site(null, "Titanic", "Plot", "Poster", "SiteId");
//		site = dao.createSite(site);
//		System.out.println(site.getId());
		
//		Site titanic = dao.readSiteById(3);
//		System.out.println(titanic.getTitle());
		
//		dao.deleteSite(4);
		
		List<Site> sites = dao.findAllSites();
		for (Site site : sites) {
			System.out.println(site.getName());
		}
		
//		titanic.setPlot("Titanic sinks at the end");
//		dao.updateSite(titanic);
		
	}

}
