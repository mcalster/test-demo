package dk.alster.it.demo.testdemo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Task {

    private String title;


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
}
