/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.model.stats.calc.functions;

import ch.lambdaj.Lambda;
import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.player.Equipment;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.stats.calc.Stat2;
import com.aionemu.gameserver.model.stats.container.StatEnum;
import com.aionemu.gameserver.model.templates.item.ItemTemplate;
import java.util.ArrayList;
import java.util.List;

class DuplicateStatFunction extends StatFunction {

<<<<<<< .mine
  public void apply(Stat2 stat) {
    Item mainWeapon = ((Player)stat.getOwner()).getEquipment().getMainHandWeapon();
    Item offWeapon = ((Player)stat.getOwner()).getEquipment().getOffHandWeapon();
    if (mainWeapon != null) {
      StatFunction func1 = null;
      StatFunction func2 = null;
      List<StatFunction> functions = new ArrayList();
      List<StatFunction> functions1 = mainWeapon.getItemTemplate().getModifiers();
      if (functions1 != null) {
        List<StatFunction> f1 = getFunctions(functions1, stat, mainWeapon);
        if (!f1.isEmpty()) {
          func1 = (StatFunction)f1.get(0);
          functions.addAll(f1);
        }
      }
      if (mainWeapon.hasFusionedItem()) {
        ItemTemplate template = mainWeapon.getFusionedItemTemplate();
        List<StatFunction> functions2 = template.getModifiers();
        if (functions2 != null) {
          List<StatFunction> f2 = getFunctions(functions2, stat, mainWeapon);
          if (!f2.isEmpty()) {
            func2 = (StatFunction)f2.get(0);
            functions.addAll(f2);
          }
        }
      }
      else if (offWeapon != null) {
        List<StatFunction> functions2 = offWeapon.getItemTemplate().getModifiers();
        if (functions2 != null) {
          functions.addAll(getFunctions(functions2, stat, offWeapon));
        }
      }
      if ((func1 != null) && (func2 != null)) {
        if (Math.abs(func1.getValue()) >= Math.abs(func2.getValue())) {
          functions.remove(func2);
        } else {
          functions.remove(func1);
        }
      }
      if (!functions.isEmpty()) {
        if (getName() == StatEnum.PVP_ATTACK_RATIO) {
          ((StatFunction)Lambda.forEach(functions)).apply(stat);
        } else {
          ((StatFunction)Lambda.selectMax(functions, Integer.valueOf(((StatFunction)Lambda.on(StatFunction.class)).getValue()))).apply(stat);
        }
        functions.clear();
      }
    }
  }
=======
	@Override
	public void apply(Stat2 stat) {
		Item mainWeapon = ((Player) stat.getOwner()).getEquipment().getMainHandWeapon();
		Item offWeapon = ((Player) stat.getOwner()).getEquipment().getOffHandWeapon();
		if (mainWeapon != null) {
			StatFunction func1 = null;
			StatFunction func2 = null;
			List<StatFunction> functions = new ArrayList<StatFunction>();
			List<StatFunction> functions1 = mainWeapon.getItemTemplate().getModifiers();
			if (functions1 != null) {
				List<StatFunction> f1 = getFunctions(functions1, stat, mainWeapon);
				if (!f1.isEmpty()) {
					func1 = f1.get(0);
					functions.addAll(f1);
				}
			}
			if (mainWeapon.hasFusionedItem()) {
				ItemTemplate template = mainWeapon.getFusionedItemTemplate();
				List<StatFunction> functions2 = template.getModifiers();
				if (functions2 != null) {
					List<StatFunction> f2 = getFunctions(functions2, stat, mainWeapon);
					if (!f2.isEmpty()) {
						func2 = f2.get(0);
						functions.addAll(f2);
					}
				}
			} else if (offWeapon != null) {
				List<StatFunction> functions2 = offWeapon.getItemTemplate().getModifiers();
				if (functions2 != null) {
					functions.addAll(getFunctions(functions2, stat, offWeapon));
				}
			}
			if ((func1 != null) && (func2 != null)) {
				if (Math.abs(func1.getValue()) >= Math.abs(func2.getValue())) {
					functions.remove(func2);
				} else {
					functions.remove(func1);
				}
			}
			if (!functions.isEmpty()) {
				if (getName() == StatEnum.PVP_ATTACK_RATIO) {
					Lambda.forEach(functions).apply(stat);
				} else {
					((StatFunction) Lambda.selectMax(functions, Integer.valueOf(Lambda.on(StatFunction.class).getValue()))).apply(stat);
				}
				functions.clear();
			}
		}
	}
>>>>>>> .r274

<<<<<<< .mine
  private List<StatFunction> getFunctions(List<StatFunction> list, Stat2 stat, Item item) {
    List<StatFunction> functions = new ArrayList();
    for (StatFunction func : list) {
      StatFunctionProxy func2 = new StatFunctionProxy(item, func);
      if ((func.getName() == getName()) && (func2.validate(stat, func2))) {
        functions.add(func);
      }
    }
    return functions;
  }
  
  public int getPriority() {
    return 60;
  }
=======
	private List<StatFunction> getFunctions(List<StatFunction> list, Stat2 stat, Item item) {
		List<StatFunction> functions = new ArrayList<StatFunction>();
		for (StatFunction func : list) {
			StatFunctionProxy func2 = new StatFunctionProxy(item, func);
			if ((func.getName() == getName()) && (func2.validate(stat, func2))) {
				functions.add(func);
			}
		}
		return functions;
	}

	@Override
	public int getPriority() {
		return 60;
	}
>>>>>>> .r274
}