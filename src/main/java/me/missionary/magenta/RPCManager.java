package me.missionary.magenta;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.DiscordBuild;
import com.jagrosh.discordipc.entities.RichPresence;
import com.jagrosh.discordipc.exceptions.NoDiscordClientException;

import java.time.OffsetDateTime;

/**
 * @author Missionary (missionarymc@gmail.com)
 * @since 6/5/2018
 */ // TODO: 8/26/2018 THIS DOESN'T WORK -> Needs a re-write!
public class RPCManager implements IPCListener {

    private IPCClient client;

    public RPCManager() {
        this.client = new IPCClient(453684637919608843L);
        this.client.setListener(this);
        try {
            client.connect(DiscordBuild.ANY);
        } catch (NoDiscordClientException e) {
            e.printStackTrace();
        }
        RichPresence.Builder builder = new RichPresence.Builder();
        client.sendRichPresence(builder.setLargeImage("magenta")
                .setState("Playing Minecraft")
                .setDetails("With Magenta Mod")
                .setStartTimestamp(OffsetDateTime.now()).build());
    }

    public void close() {
        this.client.close();
    }
}
