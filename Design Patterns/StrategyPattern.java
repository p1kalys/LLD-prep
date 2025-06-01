interface WalkableRobot {
    void walk();
}

class NormalWalk implements WalkableRobot {
    @Override
    public void walk() {
        System.out.println("Walking normally.");
    }
}

class NoWalk implements WalkableRobot {
    @Override
    public void walk() {
        System.out.println("Cannot walk.");
    }
}

interface TalkableRobot {
    void talk();
}

class NormalTalk implements TalkableRobot {
    @Override
    public void talk() {
        System.out.println("Talking normally.");
    }
}

class NoTalk implements TalkableRobot {
    @Override
    public void talk() {
        System.out.println("Cannot talk.");
    }
}

interface FlyableRobot {
    void fly();
}

class NormalFly implements FlyableRobot {
    @Override
    public void fly() {
        System.out.println("Flying normally.");
    }
}

class NoFly implements FlyableRobot {
    @Override
    public void fly() {
        System.out.println("Cannot fly.");
    }
}

abstract class Robot {
    private WalkableRobot walkBehavior;
    private TalkableRobot talkBehavior;
    private FlyableRobot flyBehavior;

    public Robot(WalkableRobot walkBehavior, TalkableRobot talkBehavior, FlyableRobot flyBehavior) {
        this.walkBehavior = walkBehavior;
        this.talkBehavior = talkBehavior;
        this.flyBehavior = flyBehavior;
    }

    public void performWalk() {
        walkBehavior.walk();
    }

    public void performTalk() {
        talkBehavior.talk();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public abstract void projection();
}

class CompanionRobot extends Robot {
    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}

class ServiceRobot extends Robot {
    public ServiceRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("Displaying service robot features...");
    }
}

class SecurityRobot extends Robot {
    public SecurityRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("Displaying security robot features...");
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Robot companionRobot = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly());
        companionRobot.performWalk();
        companionRobot.performTalk();
        companionRobot.performFly();
        companionRobot.projection();

        Robot serviceRobot = new ServiceRobot(new NoWalk(), new NormalTalk(), new NormalFly());
        serviceRobot.performWalk();
        serviceRobot.performTalk();
        serviceRobot.performFly();
        serviceRobot.projection();

        Robot securityRobot = new SecurityRobot(new NormalWalk(), new NoTalk(), new NoFly());
        securityRobot.performWalk();
        securityRobot.performTalk();
        securityRobot.performFly();
        securityRobot.projection();
    }
}