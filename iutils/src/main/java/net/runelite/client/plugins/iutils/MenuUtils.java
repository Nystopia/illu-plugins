package net.runelite.client.plugins.iutils;

import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

@Slf4j
@Singleton
public class MenuUtils
{
	@Inject
	private Client client;

	public MenuEntry entry;

	public boolean consumeClick;
	public boolean modifiedMenu;
	public int modifiedItemID;
	public int modifiedItemIndex;
	public int modifiedOpCode;

	public void setSelectedSpell(WidgetInfo info)
	{
		final Widget widget = client.getWidget(info);

		if (widget != null)
		{
			client.setSelectedSpellWidget(widget.getId());
			client.setSelectedSpellChildIndex(-1);
		}
	}

	public void setEntry(MenuEntry menuEntry)
	{
		entry = menuEntry;
	}

	public void setEntry(MenuEntry menuEntry, boolean consume)
	{
		entry = menuEntry;
		consumeClick = consume;
	}

	public void setModifiedEntry(MenuEntry menuEntry, int itemID, int itemIndex, int opCode)
	{
		entry = menuEntry;
		modifiedMenu = true;
		modifiedItemID = itemID;
		modifiedItemIndex = itemIndex;
		modifiedOpCode = opCode;
	}

}
