package com.example.demo.model.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IClienteDao;
import com.example.demo.model.dao.IFacturaDao;
import com.example.demo.model.dao.IProductoDao;
import com.example.demo.model.entity.Cliente;
import com.example.demo.model.entity.Factura;
import com.example.demo.model.entity.Producto;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id);
	}
	
	@Override
	public Cliente fetchByIdWithFacturas(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.fetchByIdWithFacturas(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Producto> findProductoById(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Factura> findFacturaById(Long id) {
		return facturaDao.findById(id);
	}

	@Override
	@Transactional
	public void deleteFactura(Long id) {
		facturaDao.deleteById(id);
	}

	@Override
	@Transactional
	public Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id) {
		// TODO Auto-generated method stub
		return facturaDao.fetchByIdWithClienteWithItemFacturaWithProducto(id);
	}

}
