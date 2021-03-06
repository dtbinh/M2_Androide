package sma.actionsBehaviours;

import com.jme3.math.Vector3f;

import env.jme.Situation;
import sma.AbstractAgent;
import jade.core.behaviours.TickerBehaviour;

public class FollowBehaviour extends TickerBehaviour {

	private static final long serialVersionUID = 1L;
	private AbstractAgent target = null;
	
	public FollowBehaviour(final AbstractAgent myagent) {
		// TODO Auto-generated constructor stub
		super(myagent, 200);
	}

	@Override
	protected void onTick() {
		if(target == null)
		{
			Vector3f currentpos  = ((AbstractAgent)this.myAgent).getCurrentPosition();
			Vector3f dest = ((AbstractAgent)this.myAgent).getDestination();
			
			if (dest==null || approximativeEqualsCoordinates(currentpos, dest)) 
			{
				((AbstractAgent)this.myAgent).randomMove();
			}
			
			Situation sit = ((AbstractAgent)this.myAgent).observeAgents();
		}
		else 
		{
			
		}
	}
	
	private boolean approximativeEqualsCoordinates(Vector3f a, Vector3f b) {
		return approximativeEquals(a.x, b.x) && approximativeEquals(a.z, b.z);
	}
	
	private boolean approximativeEquals(float a, float b) {
		return b-2.5 <= a && a <= b+2.5;
	}
}
