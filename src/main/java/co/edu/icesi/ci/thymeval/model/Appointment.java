package co.edu.icesi.ci.thymeval.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Entity
@Data
public class Appointment {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@NotNull(message="La fecha no puede estar vacía.")
	@FutureOrPresent(message="La fecha debe ser del día de hoy o futura.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@NotNull(message="La hora no puede estar vacía.")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime time;
	
	@NotNull(message="Debe seleccionar un paciente")
	@ManyToOne
	private User patient;
	
	@ManyToOne
	private User doctor;
}
