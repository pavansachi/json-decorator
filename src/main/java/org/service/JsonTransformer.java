package org.service;

interface JsonTransformer<T, I> {

	public I getInput();
	public T transform();
}