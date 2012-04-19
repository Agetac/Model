package org.agetac.common.observer;

import java.util.Observable;

/**
 * Sous-classe de java.util.Observable qui rend publique
 * la méthode setChanged()
 * @author leiko
 *
 */
public class MyObservable extends Observable {

	public void setChanged() {
		super.setChanged();
	}
}
