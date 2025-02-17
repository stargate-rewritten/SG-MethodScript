package me.pseudoknight.CHStargate;

import java.util.HashMap;
import java.util.Map;

import com.laytonsmith.core.constructs.CBoolean;
import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.events.BindableEvent;
import com.laytonsmith.core.exceptions.EventException;
import com.laytonsmith.core.exceptions.PrefilterNonMatchException;
import com.laytonsmith.core.natives.interfaces.Mixed;

import me.pseudoknight.CHStargate.abstraction.MSStargateCloseEvent;

public class stargate_close extends StargateEvent{

    @Override
    public String getName() {
        return "stargate_close";
    }
    
    @Override
    public String docs() {
        return "{} "
                + "Fired when a Stargate closes."
                + " {is_force: Wheter the closing is forced | portal: The Stargate portal's name."
                + " | network: The Stargate network this portal belongs to.}"
                + "{} "
                + "{} ";
    }

    @Override
    public Map<String, Mixed> evaluate(BindableEvent event) throws EventException {
        MSStargateCloseEvent e = (MSStargateCloseEvent) event;
        Map<String, Mixed> map = new HashMap<>();
        map.put("is_force", CBoolean.get(e.getForce()));
        map.put("portal", new CString(e.getPortal().getName(), Target.UNKNOWN));
        map.put("network", new CString(e.getPortal().getNetwork().getName(), Target.UNKNOWN));
        return map;
    }

    

    @Override
    public boolean matches(Map<String, Mixed> prefilter, BindableEvent e) throws PrefilterNonMatchException {
        return true;
    }

    @Override
    public boolean modifyEvent(String key, Mixed value, BindableEvent event) {
        return false;
    }

}
