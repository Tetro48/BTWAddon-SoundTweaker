package net.tetro48.sound_tweaker;

import btw.AddonHandler;
import btw.BTWAddon;
import btw.util.sounds.AddonSoundRegistryEntry;

public class SoundTweakerAddon extends BTWAddon {
    private static SoundTweakerAddon instance;

    //all of this is necessary.
    public static AddonSoundRegistryEntry BELLOWS_BLOW = new AddonSoundRegistryEntry("btw:block.bellows.blow");
    public static AddonSoundRegistryEntry BELLOWS_SUCK = new AddonSoundRegistryEntry("btw:block.bellows.suck");
    public static AddonSoundRegistryEntry GEARBOX_AMBIENT = new AddonSoundRegistryEntry("btw:block.gearbox.ambient");
    public static AddonSoundRegistryEntry MECHANICAL_BREAK = new AddonSoundRegistryEntry("btw:block.mechanical.break");
    public static AddonSoundRegistryEntry MILLSTONE_IDLE = new AddonSoundRegistryEntry("btw:block.mill_stone.idle");
    public static AddonSoundRegistryEntry MILLSTONE_ACTIVE = new AddonSoundRegistryEntry("btw:block.mill_stone.active");
    public static AddonSoundRegistryEntry MILLSTONE_INVALID = new AddonSoundRegistryEntry("btw:block.mill_stone.invalid");
    public static AddonSoundRegistryEntry SAW_CUT = new AddonSoundRegistryEntry("btw:block.saw.cut");
    public static AddonSoundRegistryEntry SAW_POWERED = new AddonSoundRegistryEntry("btw:block.saw.powered");
    public static AddonSoundRegistryEntry SAW_UNPOWERED = new AddonSoundRegistryEntry("btw:block.saw.unpowered");
    public static AddonSoundRegistryEntry WINDMILL_OVERPOWERING = new AddonSoundRegistryEntry("btw:entity.wind_mill.overpowering");

    public SoundTweakerAddon() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }
}