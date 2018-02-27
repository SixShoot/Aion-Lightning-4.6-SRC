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


package quest.gelkmaros;

import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.Npc;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import static com.aionemu.gameserver.network.aion.serverpackets.SM_SYSTEM_MESSAGE.*;
import com.aionemu.gameserver.questEngine.handlers.HandlerResult;
import com.aionemu.gameserver.questEngine.handlers.QuestHandler;
import com.aionemu.gameserver.model.DialogAction;
import com.aionemu.gameserver.questEngine.model.QuestEnv;
import com.aionemu.gameserver.questEngine.model.QuestState;
import com.aionemu.gameserver.questEngine.model.QuestStatus;
import com.aionemu.gameserver.services.instance.InstanceService;
import com.aionemu.gameserver.services.teleport.TeleportService2;
import com.aionemu.gameserver.utils.PacketSendUtility;
import com.aionemu.gameserver.world.WorldMapInstance;

/**
 * @author Gigi
 * @reworked vlog, apozema
 */
public class _20021TheAetherMustFlow extends QuestHandler {

<<<<<<< .mine
    private final static int questId = 20021;
    private final static int[] npcs = {799226, 799247, 799250, 799325, 799503, 799258, 799239};
=======
	private final static int questId = 20021;
	private final static int[] npc_ids = { 799226, 799247, 799250, 799325, 799503, 799258, 799239 };
>>>>>>> .r274

    public _20021TheAetherMustFlow() {
        super(questId);
    }
	
<<<<<<< .mine
    @Override
    public void register() {
        qe.registerOnEnterZoneMissionEnd(questId);
        qe.registerOnLevelUp(questId);
        qe.registerOnEnterWorld(questId);
        qe.registerOnDie(questId);
        qe.registerQuestNpc(215992).addOnKillEvent(questId);
        qe.registerQuestNpc(215995).addOnKillEvent(questId);
        qe.registerQuestNpc(215488).addOnKillEvent(questId);
        for (int npc : npcs) {
            qe.registerQuestNpc(npc).addOnTalkEvent(questId);
        }
        qe.registerQuestItem(182207604, questId);
        qe.registerQuestItem(182207603, questId);
    }
=======
	@Override
	public void register() {
		qe.registerOnEnterZoneMissionEnd(questId);
		qe.registerOnLevelUp(questId);
		qe.registerOnEnterWorld(questId);
		qe.registerOnDie(questId);
		qe.registerQuestNpc(215992).addOnKillEvent(questId);
		qe.registerQuestNpc(215995).addOnKillEvent(questId);
		qe.registerQuestNpc(215488).addOnKillEvent(questId);
		for (int npc_id : npc_ids) {
			qe.registerQuestNpc(npc_id).addOnTalkEvent(questId);
		}
		qe.registerQuestItem(182207604, questId);
		qe.registerQuestItem(182207603, questId);
	}
>>>>>>> .r274

<<<<<<< .mine
    @Override
    public boolean onDialogEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        if (qs == null) {
            return false;
        }
        int var = qs.getQuestVarById(0);
        int targetId = env.getTargetId();
        DialogAction dialog = env.getDialog();
=======
	@Override
	public boolean onZoneMissionEndEvent(QuestEnv env) {
		return defaultOnZoneMissionEndEvent(env);
	}

	@Override
	public boolean onLvlUpEvent(QuestEnv env) {
		return defaultOnLvlUpEvent(env, 20000, true);
	}

	@Override
	public boolean onDialogEvent(final QuestEnv env) {
		final Player player = env.getPlayer();
		final QuestState qs = player.getQuestStateList().getQuestState(questId);
		if (qs == null) {
			return false;
		}

		int var = qs.getQuestVarById(0);
		int targetId = 0;
		if (env.getVisibleObject() instanceof Npc) {
			targetId = ((Npc) env.getVisibleObject()).getNpcId();
		}
>>>>>>> .r274

<<<<<<< .mine
        if (qs.getStatus() == QuestStatus.START) {
            if (targetId == 799226) { // Valetta
                switch (dialog) {
                    case QUEST_SELECT: {
                        if (var == 0) {
                            return sendQuestDialog(env, 1011);
                        }
                    }
                    case SETPRO1: {
                        return defaultCloseDialog(env, 0, 1); // 1
                    }
                }
            } else if (targetId == 799247) { // Angrad
                switch (dialog) {
                    case QUEST_SELECT: {
                        if (var == 1) {
                            return sendQuestDialog(env, 1352);
                        }
                    }
                    case SETPRO2: {
                        return defaultCloseDialog(env, 1, 2); // 2
                    }
                }
            } else if (targetId == 799250) { // Eddas
                switch (dialog) {
                    case QUEST_SELECT: {
                        if (var == 2) {
                            return sendQuestDialog(env, 1693);
                        }
                    }
                    case SETPRO3: {
                        return defaultCloseDialog(env, 2, 3); // 3
                    }
                }
            } else if (targetId == 799325) { // Taloc's Guardian
                switch (dialog) {
                    case QUEST_SELECT: {
                        if (var == 3) {
                            return sendQuestDialog(env, 2034);
                        } else if (var == 4) {
                            return sendQuestDialog(env, 2120);
                        } else if (var == 5) {
                            return sendQuestDialog(env, 2716);
                        }
                    }
                    case SETPRO4: {
                        return defaultCloseDialog(env, 3, 4); // 4
                    }
                    case SETPRO6: {
                        if (player.isInGroup2()) {
                            return sendQuestDialog(env, 2717);
                        } else {
                            if (giveQuestItem(env, 182207603, 1) && giveQuestItem(env, 182207604, 1)) {
                                WorldMapInstance newInstance = InstanceService.getNextAvailableInstance(300190000);
                                InstanceService.registerPlayerWithInstance(newInstance, player);
                                TeleportService2.teleportTo(player, 300190000, newInstance.getInstanceId(), 202.26694f, 226.0532f,
                                        1098.236f, (byte) 30);
                                changeQuestStep(env, 5, 6, false); // 6
                                return closeDialogWindow(env);
                            } else {
                                PacketSendUtility.sendPacket(player, STR_MSG_FULL_INVENTORY);
                                return sendQuestSelectionDialog(env);
                            }
                        }
                    }
                    case FINISH_DIALOG: {
                        return sendQuestSelectionDialog(env);
                    }
                }
            } else if (targetId == 799503) { // Taloc's Mirage
                switch (dialog) {
                    case QUEST_SELECT: {
                        if (var == 9) {
                            return sendQuestDialog(env, 4080);
                        }
                    }
                    case SETPRO10: {
                        return defaultCloseDialog(env, 9, 10); // 10
                    }
                }
            } else if (targetId == 799258) { // Denskel
                switch (dialog) {
                    case QUEST_SELECT: {
                        if (var == 10) {
                            return sendQuestDialog(env, 1267);
                        }
                    }
                    case SETPRO11: {
                        return defaultCloseDialog(env, 10, 11); // 11
                    }
                }
            } else if (targetId == 799239) { // Vellun
                switch (dialog) {
                    case QUEST_SELECT: {
                        if (var == 11) {
                            return sendQuestDialog(env, 1608);
                        }
                    }
                    case SET_SUCCEED: {
                        return defaultCloseDialog(env, 11, 11, true, false); // reward
                    }
                }
            }
        } else if (qs.getStatus() == QuestStatus.REWARD) {
            if (targetId == 799226) { // Valetta
                if (dialog == DialogAction.QUEST_SELECT) {
                    return sendQuestDialog(env, 10002);
                } else {
                    return sendQuestEndDialog(env);
                }
            }
        }
        return false;
    }
=======
		if (qs.getStatus() == QuestStatus.REWARD) {
			if (targetId == 799226) { // Valetta
				if (env.getDialog() == DialogAction.QUEST_SELECT) {
					return sendQuestDialog(env, 10002);
				} else {
					return sendQuestEndDialog(env);
				}
			}
			return false;
		} else if (qs.getStatus() != QuestStatus.START) {
			return false;
		}
		if (targetId == 799226) { // Valetta
			switch (env.getDialog()) {
				case QUEST_SELECT:
					if (var == 0) {
						return sendQuestDialog(env, 1011);					
					}
					case SETPRO1:
						return defaultCloseDialog(env, 0, 1);
					default:
						break;
			}
		} else if (targetId == 799247) { // Angrad
			switch (env.getDialog()) {
				case QUEST_SELECT:
					if (var == 1) {
						return sendQuestDialog(env, 1352);
					}
					case SETPRO2: 
						return defaultCloseDialog(env, 1, 2);
					default:
						break;
			}
		} else if (targetId == 799250) { // Eddas
			switch (env.getDialog()) {
				case QUEST_SELECT:
					if (var == 2) {
						return sendQuestDialog(env, 1693);
					}
					case SETPRO3:
						return defaultCloseDialog(env, 2, 3);
					default:
						break;
			}
		} else if (targetId == 799325) { // Taloc's Guardian
			switch (env.getDialog()) {
				case QUEST_SELECT:
					if (var == 3) {
						return sendQuestDialog(env, 2034);
					// if (var == 4) { TODO: Show Quest Dialog when QuestVar < 5/5
					//	return sendQuestDialog(env, 2120);
					} else if (qs.getQuestVarById(1) == 5 || qs.getQuestVarById(2) == 5 || qs.getQuestVarById(0) == 4) {
						changeQuestStep(env, 4, 5, false);
						return sendQuestDialog(env, 2716);
					}
				case SETPRO4:
					return defaultCloseDialog(env, 3, 4); 
				case SETPRO6:
					if (player.isInGroup2()) {
						return sendQuestDialog(env, 2717);
					} else {
						if (giveQuestItem(env, 182207603, 1) && giveQuestItem(env, 182207604, 1)) {
							WorldMapInstance newInstance = InstanceService.getNextAvailableInstance(300190000);
							InstanceService.registerPlayerWithInstance(newInstance, player);
							TeleportService2.teleportTo(player, 300190000, newInstance.getInstanceId(), 202.26694f, 226.0532f, 1098.236f, (byte) 30);
							changeQuestStep(env, 5, 6, false);
							return closeDialogWindow(env);
						} else {
							PacketSendUtility.sendPacket(player, STR_MSG_FULL_INVENTORY);
							return sendQuestSelectionDialog(env);
						}
					}
				case FINISH_DIALOG:
					return sendQuestSelectionDialog(env);
				default:
					break;
			}
		} else if (targetId == 799503) { // Taloc's Mirage
			switch (env.getDialog()) {
				case QUEST_SELECT:
					if (var == 9) {
						return sendQuestDialog(env, 4080);
					}
				case SETPRO10:
					return defaultCloseDialog(env, 9, 10);
				default:
					break;
			}
		} else if (targetId == 799258) { // Denskel
			switch (env.getDialog()) {
				case QUEST_SELECT:
					if (var == 10) {
						return sendQuestDialog(env, 1267);
					}
				case SETPRO11:
					return defaultCloseDialog(env, 10, 11);
				default:
					break;
			}
		} else if (targetId == 799239) { // Vellun
			switch (env.getDialog()) {
				case QUEST_SELECT:
					if (var == 11) {
						return sendQuestDialog(env, 1608);
					}
				case SET_SUCCEED:
					return defaultCloseDialog(env, 11, 11, true, false);
				default:
					break;
			}
		}
		return false;
	}
>>>>>>> .r274

<<<<<<< .mine
    @Override
    public boolean onKillEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        if (qs != null && qs.getStatus() == QuestStatus.START) {
            int targetId = env.getTargetId();
            int var = qs.getQuestVarById(0);
            int var1 = qs.getQuestVarById(1);
            int var2 = qs.getQuestVarById(2);
=======
	@Override
	public boolean onKillEvent(QuestEnv env) {
		Player player = env.getPlayer();
		QuestState qs = player.getQuestStateList().getQuestState(questId);
		if (qs == null || qs.getStatus() != QuestStatus.START) {
			return false;
		}
		
		int targetId = 0;
		if (env.getVisibleObject() instanceof Npc) {
			targetId = ((Npc) env.getVisibleObject()).getNpcId();
		}
>>>>>>> .r274

<<<<<<< .mine
            switch (targetId) {
                case 215992: { // Sticky Sludger
                    if (var == 4) {
                        if (var1 >= 0 && var1 < 4) {
                            return defaultOnKillEvent(env, 215992, 0, 5, 1); // 1: 9
                        } else if (var1 == 5) {
                            if (var2 == 5) {
                                qs.setQuestVar(5); // 5
                                updateQuestStatus(env);
                                return true;
                            } else {
                                defaultOnKillEvent(env, 215992, 5, 5, 1); // 1: 10
                            }
                        }
                    }
                    break;
                }
                case 215995: { // Whirling Seafoam
                    if (var == 4) {
                        if (var2 >= 0 && var2 < 4) {
                            return defaultOnKillEvent(env, 215995, 0, 5, 2); // 2: 9
                        } else if (var2 == 5) {
                            if (var1 == 5) {
                                qs.setQuestVar(5); // 5
                                updateQuestStatus(env);
                                return true;
                            } else {
                                return defaultOnKillEvent(env, 215995, 5, 5, 2); // 2: 10
                            }
                        }
                    }
                    break;
                }
                case 215488: { // Celestius
                    return defaultOnKillEvent(env, 215488, 8, 9); // 9
                }
            }
        }
        return false;
    }
=======
		switch (targetId) {
			case 215992: // Sticky Sludger
				if (qs.getQuestVarById(1) < 5 && qs.getQuestVarById(0) == 4) {
					qs.setQuestVarById(1, qs.getQuestVarById(1) + 1);
					updateQuestStatus(env);
					return true;
				} else if (qs.getQuestVarById(1) == 4 && qs.getQuestVarById(2) == 5 && qs.getQuestVarById(0) == 4) {
					qs.setQuestVarById(0, qs.getQuestVarById(0) + 1);
					updateQuestStatus(env);
					return true;
				}
				break;
			case 215995: // Whirling Seafoam
				if (qs.getQuestVarById(2) < 5 && qs.getQuestVarById(0) == 4) {
					qs.setQuestVarById(2, qs.getQuestVarById(2) + 1);
					updateQuestStatus(env);
					return true;
				} else if (qs.getQuestVarById(1) == 5 && qs.getQuestVarById(2) == 4 && qs.getQuestVarById(0) == 4) {
					qs.setQuestVarById(0, qs.getQuestVarById(0) + 1);
					updateQuestStatus(env);
					return true;
				}
				break;
			case 215488: // Celestius
				if (qs.getQuestVarById(0) == 8) {
					return defaultOnKillEvent(env, 215488, 8, 9);
				}
		}
		return false;
	}
>>>>>>> .r274

<<<<<<< .mine
    @Override
    public HandlerResult onItemUseEvent(final QuestEnv env, Item item) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        if (qs != null && qs.getStatus() == QuestStatus.START) {
            if (player.getWorldId() == 300190000) {
                int itemId = item.getItemId();
                int var = qs.getQuestVarById(0);
                int var3 = qs.getQuestVarById(3);
                if (itemId == 182207604) { // Taloc Fruit
                    changeQuestStep(env, 6, 7, false); // 7
                    return HandlerResult.SUCCESS; // //TODO: Should return FAILED (not removed, but skill still should be used)
                } else if (itemId == 182207603) { // Taloc's Tears
                    if (var == 7) {
                        if (var3 >= 0 && var3 < 19) {
                            changeQuestStep(env, var3, var3 + 1, false, 3); // 3: 19
                            return HandlerResult.SUCCESS;
                        } else if (var3 == 19) {
                            qs.setQuestVar(8);
                            updateQuestStatus(env);
                            return HandlerResult.SUCCESS;
                        }
                    }
                }
            }
        }
        return HandlerResult.UNKNOWN;
    }
=======
	@Override
	public HandlerResult onItemUseEvent(final QuestEnv env, Item item) {
		Player player = env.getPlayer();
		QuestState qs = player.getQuestStateList().getQuestState(questId);
		if (qs != null && qs.getStatus() == QuestStatus.START) {
			if (player.getWorldId() == 300190000) {
				int itemId = item.getItemId();
				int var = qs.getQuestVarById(0);
				int var3 = qs.getQuestVarById(3);
				if (itemId == 182207604) { // Taloc Fruit
					changeQuestStep(env, 6, 7, false); // 7
					return HandlerResult.SUCCESS; // //TODO: Should return FAILED (not removed, but skill still should be used)
				} else if (itemId == 182207603) { // Taloc's Tears
					if (var == 7) {
						if (var3 >= 0 && var3 < 19) {
							changeQuestStep(env, var3, var3 + 1, false, 3);
							return HandlerResult.SUCCESS;
						} else if (var3 == 19) {
							qs.setQuestVar(8);
							updateQuestStatus(env);
							return HandlerResult.SUCCESS;
						}
					}
				}
			}
		}
		return HandlerResult.UNKNOWN;
	}
>>>>>>> .r274

<<<<<<< .mine
    @Override
    public boolean onEnterWorldEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        if (qs != null && qs.getStatus() == QuestStatus.START) {
            if (player.getWorldId() != 300190000) {
                int var = qs.getQuestVarById(0);
                if (var >= 6 && var < 9) {
                    removeQuestItem(env, 182207604, 1);
                    removeQuestItem(env, 182207603, 1);
                    qs.setQuestVar(5);
                    updateQuestStatus(env);
                    return true;
                } else if (var == 9) { // Final boss killed
                    removeQuestItem(env, 182207604, 1);
                    removeQuestItem(env, 182207603, 1);
                    qs.setQuestVar(10);
                    updateQuestStatus(env);
                    return true;
                }
            }
        }
        return false;
    }
=======
	@Override
	public boolean onEnterWorldEvent(QuestEnv env) {
		Player player = env.getPlayer();
		QuestState qs = player.getQuestStateList().getQuestState(questId);
		if (qs != null && qs.getStatus() == QuestStatus.START) {
			if (player.getWorldId() != 300190000) {
				int var = qs.getQuestVarById(0);
				if (var >= 6 && var < 9) {
					removeQuestItem(env, 182207604, 1);
					removeQuestItem(env, 182207603, 1);
					qs.setQuestVar(5);
					updateQuestStatus(env);
					return true;
				} else if (var == 9) {
					removeQuestItem(env, 182207604, 1);
					removeQuestItem(env, 182207603, 1);
					qs.setQuestVar(10);
					updateQuestStatus(env);
					return true;
				}
			}
		}
		return false;
	}
>>>>>>> .r274

    @Override
    public boolean onDieEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        if (qs != null && qs.getStatus() == QuestStatus.START) {
            int var = qs.getQuestVarById(0);
            if (var >= 6 && var < 9) {
                removeQuestItem(env, 182207604, 1);
                removeQuestItem(env, 182207603, 1);
                qs.setQuestVar(5);
                updateQuestStatus(env);
                return true;
            }
        }
        return false;
    }
<<<<<<< .mine

    @Override
    public boolean onZoneMissionEndEvent(QuestEnv env) {
        return defaultOnZoneMissionEndEvent(env);
    }

    @Override
    public boolean onLvlUpEvent(QuestEnv env) {
        return defaultOnLvlUpEvent(env, 20000, true);
    }
=======
>>>>>>> .r274
}