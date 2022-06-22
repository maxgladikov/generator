package entities;

import java.util.*;

import entities.aux.ModbusItem;
import entities.aux.Task;
import entities.kep.Channel;
import entities.linkMaster.LinkGroup;
import entities.linkMaster.LinkItemInput;
import entities.linkMaster.LinkItemOutput;
import generator.util.DCSmap;
import generator.util.MyList;
import lombok.Builder;
import lombok.Data;
import lombok.val;
import constants.Constants;

@Data
public  class MyObject {
	protected String tag;
	private String type;
	private String description;
	private String adapter;
	private LinkGroup linkGroup;
	protected List<LinkItemInput> linkItemInputs=new ArrayList();
	protected List<LinkItemOutput> linkItemOutputs=new ArrayList();
	private MyList list;
	protected  DCSmap dcsMap;
	protected Channel channel;
	protected Map<String,ModbusItem> pattern;
	
	public MyObject(Task task){
		Comparator<ModbusItem> comparator=Comparator.comparing(ModbusItem::getAccess).thenComparing(ModbusItem::getDataType);
		tag=task.getTag();
		type=task.getType();
		adapter=task.getAdapter();
		linkGroup=new LinkGroup(tag.replace("-", "_"), description);
		pattern=task.getPattern();
		
//		System.out.println(adapter);
//		System.out.println(Constants.getAdapters().get(adapter));
		channel=new Channel(Constants.getRandom(),tag,Constants.getAdapters().get(adapter),tag,task.getSlaveAddress(),type=="MVmotor"?false:true);
		Collection<ModbusItem> values=pattern.values();
		values.stream().sorted(comparator).forEach(x->linkItemInputs.add(new LinkItemInput(x,tag)));
		Task.getRC().next();
}
	
	public String getLinkInputsString() {
		StringBuilder sb=new StringBuilder();
		for (LinkItemInput input : linkItemInputs) {
			sb.append(input.toString());
		}
		return sb.toString();
	};
	public String getLinkOutputsString() {
		StringBuilder sb=new StringBuilder();
		for (LinkItemInput output : linkItemInputs) {
			sb.append(output.getLinkItemOutput().toString());
		}
		return sb.toString();
	};
	public String getLinkGroupString() {
		return linkGroup.toString();
	};
	
}
