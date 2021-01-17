package com.crystaldata.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystaldata.osworks.domain.exception.EntidadeNaoEncontradaException;
import com.crystaldata.osworks.domain.exception.NegocioException;
import com.crystaldata.osworks.domain.model.Cliente;
import com.crystaldata.osworks.domain.model.Comentario;
import com.crystaldata.osworks.domain.model.OrdemServico;
import com.crystaldata.osworks.domain.model.StatusOrdemServico;
import com.crystaldata.osworks.domain.repository.ClienteRepository;
import com.crystaldata.osworks.domain.repository.ComentarioRepository;
import com.crystaldata.osworks.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
	}
	
	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));
		
		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);
	
		return comentarioRepository.save(comentario);
	}

}
