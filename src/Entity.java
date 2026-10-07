/*
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using UnityEngine;
using UnityEngine.Animations;
using UnityEngine.Events;
using UnityEngine.Playables;

public class Entity : MonoBehaviour
{

    //An entity is split into two main chuncks of code
    //Animation, which controls the appearance of an entity
    //Behavior, which controls the actions of an entity
    //Behavior can call from Animation, but no vice versa

    [Header("Entity")]
    [Tooltip("Set to -1 to make indestructable.")]
    public Vector3 position {get{return transform.position;} set{transform.position = value;}}
    public bool aggro;
    public Entity aggroTarget;
    public EntityType entityType;
    public List<EntityType> aggroTargets;
    public bool activeAI;
    public bool detectable = true;
    public int agroRange;
    public int maxHealth;
    public int health;
    public int maxDefense;
    public int defense;
    public Animator animator;
    public List<UnityEvent> OnDeathEvents;
    public List<UnityEvent> OnHitEvents;

    public void ActiveAI(bool active)
    {
        activeAI = active;
    }
    public List<Entity> GetNearbyEntities()
    {
        HashSet<Entity> entities = new();
        Collider[] entityColliders = Physics.OverlapSphere(position, agroRange, LayerMask.GetMask("Entity"));
        foreach(Collider collider in entityColliders) {
            Entity detectedEntity = collider.GetComponentInParent<Entity>();
            if(detectedEntity != this && detectedEntity.detectable)
            entities.Add(detectedEntity);
        }
        return entities.ToList();
    }
    public float DistanceBetween(Entity target)
    {
        return Vector3.Distance(position, target.position);
    }
    protected bool AggroCheck()
    {
        aggroTarget = null;
        float closestDistance = float.MaxValue;
        List<Entity> entities = GetNearbyEntities();
        foreach(Entity entity in entities)
        {
            if (aggroTargets.Contains(entity.entityType) && DistanceBetween(entity) < closestDistance)
            {
                aggroTarget = entity;
                closestDistance = DistanceBetween(entity);
            }
        }

        return aggroTarget != null;
    }
    public virtual Vector3 PathTowards(Entity target)
    {
        return Vector3.Normalize(target.position-position);

    }
    protected virtual void Behavior()
    {
        if(!activeAI) return;
        aggro = AggroCheck();
        if(!aggro) IdleBehavior();
        if(aggro) AggroBehavior();
    }
    protected virtual void IdleBehavior()
    {

    }
    protected virtual void AggroBehavior()
    {

    }
    public virtual void TakeDamage(HurtData data)
    {
        foreach(UnityEvent onHitEvent in OnHitEvents)
        onHitEvent.Invoke();

        if(maxHealth == -1) return;
        health -= data.damage * (101 - defense) / 100;;

        if(health <= 0)
            OnDeath();
    }
    public virtual void OnDeath()
    {
        foreach(UnityEvent onDeathEvent in OnDeathEvents)
        onDeathEvent.Invoke();
        Destroy(gameObject);
    }
}
public enum EntityType
{
    Default,
    Creature,
    Interactable,
    Player
}

 */

public class Entity extends Object{
    public Entity(){

    }
}