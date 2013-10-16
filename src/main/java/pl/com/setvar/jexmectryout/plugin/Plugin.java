package pl.com.setvar.jexmectryout.plugin;

import com.google.inject.Inject;

import pl.com.setvar.jexmectryout.pluginapi.BasePlugin;
import pl.com.setvar.jexmectryout.pluginapi.PrefixService;

/**
 * @author mlesiewski
 */
public class Plugin extends BasePlugin {

    private final String prefix;
    
    @Inject
    public Plugin(final PrefixService service) {
        this.prefix = service.getPrefix();
    }
    
    @Override
    public String getText() {
        return prefix + " World!";
    }
}
