package fr.sncf.fabssi.tododiscovery.features.todo;

import com.sun.istack.NotNull;
import fr.sncf.fabssi.tododiscovery.features.list.List;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull private Long id;
    @NotNull private String label;
    private LocalDate dueDate;
    @NotNull private boolean done;
    private LocalDateTime creationDate;

    @ManyToOne
    @NotNull private List list;
}
