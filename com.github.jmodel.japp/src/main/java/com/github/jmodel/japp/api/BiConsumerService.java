package com.github.jmodel.japp.api;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.function.BiConsumer;

import com.github.jmodel.japp.spi.BiConsumerFactory;

/**
 * BiConsumer function factory service.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class BiConsumerService {

	private static BiConsumerService cservice;

	private ServiceLoader<BiConsumerFactory> loader;

	private BiConsumerService() {
		loader = ServiceLoader.load(BiConsumerFactory.class);
	}

	public static BiConsumerService getInstance() {

		if (cservice != null) {
			return cservice;
		}

		synchronized (BiConsumerService.class) {
			if (cservice == null) {
				cservice = new BiConsumerService();
			}
			return cservice;
		}
	}

	public BiConsumer<?, ?> getBiConsumer(String funcId) {

		BiConsumer<?, ?> biConsumer = null;

		Iterator<BiConsumerFactory> biConsumerFactorys = loader.iterator();
		while (biConsumer == null && biConsumerFactorys.hasNext()) {
			BiConsumerFactory biConsumerFactory = biConsumerFactorys.next();
			biConsumer = biConsumerFactory.create(funcId);
		}

		return biConsumer;
	}

}
