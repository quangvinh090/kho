package com.demo.services;

import java.util.List;

import com.demo.entities.Cert;
import com.demo.entities.Language;

public interface CertService {
	public List<Cert> findAll();
}
