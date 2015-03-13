package expert.optimist.wildcrowd.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import expert.optimist.wildcrowd.control.CrowdEntryService;
import expert.optimist.wildcrowd.entity.CrowdEntry;

@Path("crowds")
public class WildcrowdEndpoint {

	@Inject
	CrowdEntryService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CrowdEntry create(CrowdEntry entry) {
		return service.create(entry);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CrowdEntry update(CrowdEntry entry) {
		return service.update(entry);
	}

	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		service.delete(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CrowdEntry> getAll() {
		return service.getAll();
	}
}
