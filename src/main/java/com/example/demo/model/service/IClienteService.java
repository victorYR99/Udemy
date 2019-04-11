package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.entity.Cliente;
import com.example.demo.model.entity.Factura;
import com.example.demo.model.entity.Producto;

public interface IClienteService {

public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);
	
	public Optional<Cliente> findOne(Long id);
	
	public Cliente fetchByIdWithFacturas(Long id);
	
	public void delete(Long id);
	
	public List<Producto> findByNombre(String term);
	
	public void saveFactura(Factura factura);
	
	public Optional<Producto> findProductoById(Long id);
	
	public Optional<Factura> findFacturaById(Long id);
	
	public void deleteFactura(Long id);
	
	public Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id);

}
