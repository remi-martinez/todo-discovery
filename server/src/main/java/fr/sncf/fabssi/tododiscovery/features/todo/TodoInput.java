package fr.sncf.fabssi.tododiscovery.features.todo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TodoInput {
    @NotNull private String label;
    @NotNull private boolean done;
    private LocalDate dueDate;
    @NotNull private Long listId;
}
