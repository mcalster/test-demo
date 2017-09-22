package dk.alster.it.demo.testdemo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {

    private String title;
    private String id;
}
