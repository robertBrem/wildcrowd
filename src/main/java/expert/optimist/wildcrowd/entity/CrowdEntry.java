package expert.optimist.wildcrowd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of = { "id" })
@NamedQueries({ @NamedQuery(name = "Entries.getAll", query = "SELECT entry FROM CrowdEntry entry") })
public class CrowdEntry {
	@Id
	@SequenceGenerator(name = "CrowdentriesSequence", sequenceName = "CROWDENTRIES_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CrowdentriesSequence")
	@Column(name = "CROWDENTRY_ID")
	private Long id;

	private String servername;
	private String deploymentame;
}
