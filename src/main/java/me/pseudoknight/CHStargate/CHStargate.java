package me.pseudoknight.CHStargate;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;
import me.pseudoknight.CHStargate.abstraction.Stargate.Listener;

@MSExtension("CHStargate")
public class CHStargate extends AbstractExtension {

	public Version getVersion() {
		return new SimpleVersion(2,0,1);
	}

	@Override
	public void onStartup() {
		Listener.register();
		System.out.println("CHStargate " + getVersion() + " loaded.");
	}

	@Override
	public void onShutdown() {
		Listener.unregister();
		System.out.println("CHStargate " + getVersion() + " unloaded.");
	}

}
