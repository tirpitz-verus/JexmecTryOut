package pl.com.setvar.jexmectryout;

import org.kantega.jexmec.ctor.ConstructorInjectionPluginLoader;
import org.kantega.jexmec.guice.GuicePluginLoader;
import org.kantega.jexmec.manager.DefaultPluginManager;
import org.kantega.jexmec.ServiceKey;

import pl.com.setvar.jexmectryout.pluginapi.MyServices;
import pl.com.setvar.jexmectryout.pluginapi.Plugin;
import pl.com.setvar.jexmectryout.pluginapi.PrefixService;

public class App {

    public App() {
        pluginManager = DefaultPluginManager.buildFor(Plugin.class)
                .withClassLoader(getClass().getClassLoader())
                .withPluginLoader(new GuicePluginLoader(MyServices.class))
                .withService(ServiceKey.by(PrefixService.class), new PrefixServiceImpl())
                .withPluginLoader(new ConstructorInjectionPluginLoader())
                .build();
    }
    private final DefaultPluginManager<Plugin> pluginManager;

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        pluginManager.start();

        for (Plugin plugin : pluginManager.getPlugins()) {
            System.out.println(plugin.getText());
        }

        System.out.println("finish");
    }
}
