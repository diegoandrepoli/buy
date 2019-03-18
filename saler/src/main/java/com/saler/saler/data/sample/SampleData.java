package com.saler.saler.data.sample;

import java.math.BigDecimal;

import com.saler.saler.data.sample.utils.SampleDataUtils;
import com.saler.saler.deal.entity.Deal;
import com.saler.saler.deal.repository.DealRepository;
import com.saler.saler.deal.type.enums.DealTypeEnum;

/**
 * Generate sample data
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
public class SampleData {
	
	/**
	 * Generate sample data
	 * @param dealRepository
	 */
	public static void generate(DealRepository dealRepository) {
		generateFistDeal(dealRepository);
		generateSecondDeal(dealRepository);
		generateOtherDeal(dealRepository);
	}
	
	/**
	 * Generare first deal
	 * @param deal repository
	 */
	public static void generateFistDeal(DealRepository dealRepository) {		
		
		//create sample deal
		String title = "Pizza Primer Delivery";
		String url = "pizza-primer-delivery";
		String text = "Desde 2001 levamos qualidade e sabor às casas de nossos clientes. Usamos ingredientes selecionados para que cada mordida seja inesquecível.";
		String string = DealTypeEnum.LQA.getKey();
		
		//save deal
		Deal deal = dealRepository.save(SampleDataUtils.generateDeal(title, text, string, url));
		
		//create price options
		BigDecimal normalPrice = new BigDecimal(40.20);
		BigDecimal salePrice = new BigDecimal(30.20);
		
		//create sample buy option
		title = "Pizza 8 pedaços com 2 sabores";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		
		//create sample buy option
		title = "Pizza 6 pedaços com 2 sabores";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		 
		//create sample buy option
		title = "Pizza 4 pedaços com 2 sabores";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		
		//create sample buy option
		title = "Pizza 8 pedaços com 1 sabor";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		
		//create sample buy option
		title = "Pizza 6 pedaços com 1 sabor";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		
		//create sample buy option
		title = "Pizza 4 pedaços com 1 sabor";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
	}
	
	/**
	 * Generate secondary deal
	 * @param deal repository
	 */
	public static void generateSecondDeal(DealRepository dealRepository) {		
		
		//create sample deal
		String title = "Buffet de Sushi Livre com Pratos Quentes e Hots";
		String url = "buffet-sushi-livre-pratos-quentes-hots";
		String text = "Nigiri salmão, nigiri atum, nigiri kani, nigiri skin, nigiri peixe branco, Califórnia, Filadélfia de salmão, Filadélfia de kani, hot Filadélfia, hot el fuego, sushis doces, sushis variedades da casa, pastel.";
		String string = DealTypeEnum.PRM.getKey();
		
		//save deal
		Deal deal = dealRepository.save(SampleDataUtils.generateDeal(title, text, string, url));
		
		//create price options
		BigDecimal normalPrice = new BigDecimal(40.20);
		BigDecimal salePrice = new BigDecimal(30.20);
		
		//create sample buy option
		title = "1 pessoa de segunda a quarta";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		
		//create sample buy option
		title = "1 pessoas de quinta a domingo";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		 
		//create sample buy option
		title = "2 pessoas de segunda a domingo";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		
		//create sample buy option
		title = "3 pessoas de segunda a domingo";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);		
	}
	
	/**
	 * Generate other deal
	 * @param deal repository
	 */
	public static void generateOtherDeal(DealRepository dealRepository) {		
		
		//create sample deal
		String title = "Arraial D’Ajuda 4 ou 7 noites com café da manhã!";
		String url = "arraial-d-ajuda-4-ou-7-noites-com-cafe-da-manha";
		String text = "O passeio certo em Arraial é visitar as belíssimas praias, saborear as delícias baianas nos restaurantes.";
		String string = DealTypeEnum.OFF.getKey();
		
		//save deal
		Deal deal = dealRepository.save(SampleDataUtils.generateDeal(title, text, string, url));
		
		//create price options
		BigDecimal normalPrice = new BigDecimal(40.20);
		BigDecimal salePrice = new BigDecimal(30.20);
		
		//create sample buy option
		title = "4 noites para uma pessoa";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		
		//create sample buy option
		title = "4 noites para duas pessoas";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		 
		//create sample buy option
		title = "7 noites para uma pessoa";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);
		
		//create sample buy option
		title = "7 noites para duas pessoas";
		deal.addBuyOption(SampleDataUtils.generateBuyOption(title, normalPrice, salePrice));
		deal = dealRepository.save(deal);		
	}

}
