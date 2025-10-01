package net.rimaki.emotax.item;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.customitem.CustomItem;
import cn.nukkit.item.customitem.CustomItemDefinition;
import cn.nukkit.item.customitem.data.CreativeCategory;
import cn.nukkit.math.Vector3;
import net.rimaki.emotax.gui.EmotaXCFGMenu;

public class EmotaXMenu extends Item implements CustomItem {
    public EmotaXMenu() {
        super("emotax:menu");
    }

    @Override
    public CustomItemDefinition getDefinition() {
        return CustomItemDefinition
                .simpleBuilder(this)
                .creativeCategory(CreativeCategory.ITEMS)
                .name("EmotaX Menu")
                .texture("test_sward")
                .maxStackSize(1)
                .allowOffHand(false)
                .handEquipped(true)
                .glint(false)
                .build();
    }

    @Override
    public boolean onClickAir(Player player, Vector3 directionVector) {
        EmotaXCFGMenu form = new EmotaXCFGMenu();
        player.sendForm(form);
        return false;
    }
}
