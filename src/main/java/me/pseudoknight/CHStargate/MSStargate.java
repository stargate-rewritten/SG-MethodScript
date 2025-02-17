package me.pseudoknight.CHStargate;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.abstraction.Implementation;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;
import me.pseudoknight.CHStargate.abstraction.Stargate.Listener;
import net.TheDgtl.Stargate.api.StargateAPI;

import java.util.logging.Level;

import org.bukkit.Bukkit;

@MSExtension("CHStargate")
public class MSStargate extends AbstractExtension {

    static StargateAPI stargateAPI;
    
    
	public Version getVersion() {
		return new SimpleVersion(4,0,0);
	}

    @Override
    public void onStartup() {
        if (Implementation.GetServerType() != Implementation.Type.BUKKIT) {
            Static.getLogger().log(Level.WARNING, "CHStargate not supported on this implementation.");
            return;
        }
        Listener.register();
        Static.getLogger().log(Level.INFO, "CHStargate " + getVersion() + " loaded.");
        stargateAPI = (StargateAPI) Bukkit.getPluginManager().getPlugin("stargate");
        
    }

	@Override
	public void onShutdown() {
		if(Implementation.GetServerType() == Implementation.Type.BUKKIT) {
			Listener.unregister();
			Static.getLogger().log(Level.INFO, "CHStargate " + getVersion() + " unloaded.");
		}
	}

}
