package org.ram.service;

import java.util.List;

import org.ram.mapper.TodoMapper;
import org.ram.model.Tag;
import org.ram.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;

    public Todo getTodoById(int id) {
        return todoMapper.findById(id);
    }

    public List<Todo> getAllTodos() {
        return todoMapper.findAll();
    }

    public void createTodo(Todo todo) {
        todoMapper.insert(todo);
    }

    public void updateTodo(Todo todo) {
        todoMapper.update(todo);
    }

    public void deleteTodoById(int id) {
        todoMapper.delete(id);
    }
    
    public void createTag(Tag tag) {
        todoMapper.insertTag(tag);
    }
    
    
    public void mapTagToTodo(int todoId, int tagId) {
        todoMapper.mapTagToTodo(todoId, tagId);
    }

	public List<Tag> getAllTags() {
	return todoMapper.getAllTags();
	}

}
