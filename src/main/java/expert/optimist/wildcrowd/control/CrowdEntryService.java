package expert.optimist.wildcrowd.control;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import expert.optimist.wildcrowd.entity.CrowdEntry;

@Stateless
public class CrowdEntryService {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<CrowdEntry> getAll() {
		return em.createNamedQuery("Entries.getAll").getResultList();
	}

	public CrowdEntry create(CrowdEntry entry) {
		if (getAll().contains(entry)) {
			throw new IllegalArgumentException(entry + " does allready exist!");
		}
		return em.merge(entry);
	}

	public CrowdEntry update(CrowdEntry entry) {
		if (!getAll().contains(entry)) {
			throw new IllegalArgumentException(entry + " does not exist!");
		}
		return em.merge(entry);
	}

	public void delete(Long id) {
		CrowdEntry entry = em.find(CrowdEntry.class, id);
		em.remove(entry);
	}

}
