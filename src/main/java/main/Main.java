
package main;

import controller.ProjectController;
import controller.TaskController;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;


public class Main {
    
    public static void main(String[] args) {
        
        //ProjectController projectController = new ProjectController();
        
        //Project project = new Project();
        //project.setName("Projeto De Teste 02");
        //project.setDescription("apenas um teste");
        //projectController.save(project);
        
       // ProjectController projectController = new ProjectController();
        
       // Project project = new Project();
       // project.setId(1);
       // project.setName("Novo nome do projeto");
       // project.setDescription("description");
        
        
       // projectController.update(project);
        
      // List<Project> projects = projectController.getAll();
      // System.out.println("Total de projetos = " + projects.size());
       
      // projectController.removeByID(1);
       
       TaskController taskController = new TaskController();
       
       Task task = new Task();
       task.setIdProject(3);
       task.setName("Criar p codigo");
       task.setDescription("Devem ser criados os codigos");
       task.setNotes("Sem notas");
       task.setIsCompleted(false);
       task.setDeadline(new Date());
       
       taskController.save(task);
       
       //task.setName("Alterar telas da aplicação");
       //taskController.update(task);
       //List<Task> tasks = taskController.getAll(12);
       //System.out.println("Total de tarefas = " + tasks.size());
    }
    
}
