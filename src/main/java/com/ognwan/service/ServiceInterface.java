/**
 * 
 */
package com.ognwan.service;

import java.util.List;

import com.ognwan.exceptions.AlreadyExistsException;
import com.ognwan.exceptions.NotFoundException;

/**
 * @author gerry
 * @version 1.0
 * 
 */
public interface ServiceInterface<T, U> {
	public T create(T t) throws AlreadyExistsException;

	public T update(T t, long id) throws NotFoundException;

	public T getById(long id) throws NotFoundException;

	public List<T> getAll();

	public void delete(long id);
}
