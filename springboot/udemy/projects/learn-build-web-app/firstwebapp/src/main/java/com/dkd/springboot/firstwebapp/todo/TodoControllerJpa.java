package com.dkd.springboot.firstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoControllerJpa {

//    @Autowired
//    private TodoService todoService;
    @Autowired
    private TodoRepositoty todoRepositoty;
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username= getLoggedinUsername();
        List<Todo> todos = todoRepositoty.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value ="add-todo", method= RequestMethod.GET)
    public String showNewTodoPage(ModelMap model)
    {
        Todo todo= new Todo(0, getLoggedinUsername(), "", LocalDate.now().plusYears(1), false );
        model.put("todo", todo);
        return "todo";
    }
    @RequestMapping(value= "add-todo", method= RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result)
    {
        if(result.hasErrors())  return "todo";
        String username= getLoggedinUsername();
        todo.setUsername(username);
        todoRepositoty.save(todo);
        return "redirect:list-todos";
    }
    @RequestMapping(value="delete-todo")
    public String deleteTodo(@RequestParam int id)
    {
        todoRepositoty.deleteById(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepositoty.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }
    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        String username= getLoggedinUsername();
        todo.setUsername(username);
        todoRepositoty.save(todo);
        return "redirect:list-todos";
    }
    private String getLoggedinUsername(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return  authentication.getName();
    }




}
