package prospector.modmenu.mixin;

import net.fabricmc.loader.FabricLoader;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.MainMenuGui;
import net.minecraft.client.resource.language.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import prospector.modmenu.ModMenu;
import prospector.modmenu.gui.ModMenuButtonWidget;

@Mixin(MainMenuGui.class)
public class GuiMainMenuMixin extends Gui {

	@Inject(at = @At("RETURN"), method = "initWidgetsNormal(II)V")
	public void drawMenuButton(CallbackInfo info) {
		int i = FabricLoader.INSTANCE.getMods().size();
		this.addButton(new ModMenuButtonWidget(ModMenu.getButtonIdMainMenu(), this.width / 2 - 100, this.height / 4 + 48 + 24 * (ModMenu.replacesRealmsButton() ? 2
		                                                                                                                                                        : 3), I18n.translate("modmenu.title") + " " + I18n.translate("modmenu.loaded", i), this));
	}
}