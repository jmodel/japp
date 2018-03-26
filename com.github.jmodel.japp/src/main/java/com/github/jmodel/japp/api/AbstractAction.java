package com.github.jmodel.japp.api;

import com.github.jmodel.adapter.api.ManagedObject;
import com.github.jmodel.adapter.api.TermAware;
import com.github.jmodel.adapter.api.config.Configurable;
import com.github.jmodel.adapter.spi.Term;
import com.github.jmodel.japp.JappTerms;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public abstract class AbstractAction extends ManagedObject implements Configurable, TermAware {

	//

	@Override
	public Term getRegionTerm() {
		return tfs.getTerm(JappTerms.ACTION);
	}

}
