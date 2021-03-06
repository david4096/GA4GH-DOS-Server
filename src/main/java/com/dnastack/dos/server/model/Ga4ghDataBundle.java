package com.dnastack.dos.server.model;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.JoinColumn;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ga4ghDataBundle {
	
	@Id
	@NotNull
	private String id;
	
	@Singular
	@ElementCollection
	@NotNull
	private List<String> data_object_ids;
    
	@NotNull
	private String created;
	@NotNull
	private String updated;
	
	@NotNull
	private String version;
	
	@Singular
	@ElementCollection
    @Embedded
    @NotNull
    @Valid
	private List<Checksum> checksums;
    
	private String description;
    
	@Singular
    @ElementCollection
    private List<String> aliases;
    
	@ElementCollection
    @MapKeyColumn(name="system_metadata_key")
    @Column(name="system_metadata_value")
    //@CollectionTable(name="example_attributes", joinColumns=@JoinColumn(name="example_id"))
	@NotNull
    private Map<String, String> system_metadata;
	
	@ElementCollection
    @MapKeyColumn(name="user_metadata_key")
    @Column(name="user_metadata_value")
	@NotNull
    private Map<String, String> user_metadata;
	
	/*
	 * @Entity and @Id covert the class variables into columns in the SQL database
	 * @NotNull means it's a required field
	 * @Singular is part of lombok, works with the @Builder (part of @Data) and is needed to add data to the list in our class definition
	 * @ElementCollect is needed when adding data that's in a list to the SQL database
	 * @Embedded maps non-entities to columns in the SQL database. These are user-defined types such as Checksum and URL
	 */
}
