package br.com.jonyridel.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.jonyridel.model.Sala;
import br.com.jonyridel.util.JpaUtil;

@ManagedBean
@ViewScoped
public class SalasBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Sala> salas;
	
	public void consultar() {
		EntityManager manager = JpaUtil.getEntityManager();
		Session session = (Session) manager.getDelegate();
		Criteria criteria = session.createCriteria(Sala.class);
		this.salas = criteria.list();
		//TypedQuery<Sala> query = manager.createQuery("from sala", Sala.class);
		//this.salas = query.getResultList();
	}
	
	public List<Sala> getSalas() {
		return salas;
	}

}
