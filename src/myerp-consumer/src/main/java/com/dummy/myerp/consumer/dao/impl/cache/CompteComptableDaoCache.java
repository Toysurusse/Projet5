package com.dummy.myerp.consumer.dao.impl.cache;

import java.util.List;

import com.dummy.myerp.consumer.ConsumerHelper;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;

/**
 * Cache DAO de {@link CompteComptable}
 */
public class CompteComptableDaoCache {

	// ==================== Attributs ====================
	/** The List compte comptable. */
	private static List<CompteComptable> listCompteComptable;			//******** Oltenos : passage en static pour n'avoir qu'un seul cache...

	// ==================== Constructeurs ====================
	/**
	 * Instantiates a new Compte comptable dao cache.
	 */
	public CompteComptableDaoCache() {
	}

	// ==================== Méthodes ====================
	/**
	 * Gets by numero.
	 *
	 * @param pNumero
	 *            the numero
	 * @return {@link CompteComptable} ou {@code null}
	 */
	public static CompteComptable getByNumero(Integer pNumero) {
		if (listCompteComptable == null) {
			listCompteComptable = ConsumerHelper.getDaoProxy().getComptabiliteDao().getListCompteComptable();
		}

		CompteComptable vRetour = CompteComptable.getByNumero(listCompteComptable, pNumero);
		return vRetour;
	}
}
