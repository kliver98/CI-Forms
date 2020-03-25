package co.edu.icesi.ci.thymeval.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@NotNull(message="No puede ser nulo.")
	@Size(min=2,message="Debe tener al menos 2 caracteres.")
	private String name;
	
	@NotBlank(message="No puede ser blanco.")
	@Email(message="Debe ser un correo electrónico válido.")
	private String email;
	
	@NotNull(message="No puede ser vacío.")
	private UserType type;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message="La fecha debe ser anterior a la de hoy.")
	private LocalDate birthDate;
	
	@NotNull(message="No puede ser vacío.")
	private UserGender gender;
	
//	@OneToMany
//	private List<Appointment> appointments;
}
